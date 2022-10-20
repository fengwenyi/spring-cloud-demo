package com.fengwenyi.rpc;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-12
 */
@Slf4j
public class MyRpcRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware, ResourceLoaderAware {

    private Environment environment;
    private ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(@NotNull AnnotationMetadata metadata, @NotNull BeanDefinitionRegistry registry) {

        log.info("my rpc register");

        // 扫描 注解 @MyRpc
        LinkedHashSet<BeanDefinition> candidateComponents = new LinkedHashSet<>();
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        scanner.setResourceLoader(this.resourceLoader);
        scanner.addIncludeFilter(new AnnotationTypeFilter(MyRpc.class));
        Set<String> basePackages = getBasePackages(metadata);
        for (String basePackage : basePackages) {
            candidateComponents.addAll(scanner.findCandidateComponents(basePackage));
        }

        for (BeanDefinition candidateComponent : candidateComponents) {
            if (candidateComponent instanceof AnnotatedBeanDefinition) {
                // verify annotated class is an interface
                AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                AnnotationMetadata annotationMetadata = annotatedBeanDefinition.getMetadata();

                Map<String, Object> attributes = annotationMetadata
                        .getAnnotationAttributes(MyRpc.class.getCanonicalName());

                if (CollectionUtils.isEmpty(attributes)) {
                    log.error("");
                    throw new RuntimeException("");
                }

                String className = annotationMetadata.getClassName();
                log.info("className: [{}]", className);
                Class clazz = ClassUtils.resolveClassName(className, null);

                ConfigurableBeanFactory beanFactory = registry instanceof ConfigurableBeanFactory
                        ? (ConfigurableBeanFactory) registry : null;

                MyRpcFactoryBean factoryBean = new MyRpcFactoryBean();
                factoryBean.setBeanFactory(beanFactory);
                BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(clazz, () -> {
                    factoryBean.setUrl(resolve(null, (String) attributes.get("url")));
                    factoryBean.setContextPath((String) attributes.get("path"));
                    factoryBean.setType(clazz);
                    factoryBean.setName(className);
                    return factoryBean.getObject();
                });
                definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
                definition.setLazyInit(true);

                AbstractBeanDefinition beanDefinition = definition.getBeanDefinition();
                beanDefinition.setAttribute(FactoryBean.OBJECT_TYPE_ATTRIBUTE, className);
                beanDefinition.setAttribute("myRpcsRegistrarFactoryBean", factoryBean);

                // has a default, won't be null
                boolean primary = true;

                beanDefinition.setPrimary(primary);

                BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, className, new String[]{});
                BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
            }
        }
    }


    protected ClassPathScanningCandidateComponentProvider getScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, this.environment) {
            @Override
            protected boolean isCandidateComponent(@NotNull AnnotatedBeanDefinition beanDefinition) {
                boolean isCandidate = false;
                if (beanDefinition.getMetadata().isIndependent()) {
                    if (!beanDefinition.getMetadata().isAnnotation()) {
                        isCandidate = true;
                    }
                }
                return isCandidate;
            }
        };
    }

    protected Set<String> getBasePackages(AnnotationMetadata importingClassMetadata) {
        Set<String> basePackages = new HashSet<>();
        basePackages.add(ClassUtils.getPackageName(importingClassMetadata.getClassName()));
        return basePackages;
    }

    private String resolve(ConfigurableBeanFactory beanFactory, String value) {
        if (StringUtils.hasText(value)) {
            if (beanFactory == null) {
                return this.environment.resolvePlaceholders(value);
            }
            BeanExpressionResolver resolver = beanFactory.getBeanExpressionResolver();
            String resolved = beanFactory.resolveEmbeddedValue(value);
            if (resolver == null) {
                return resolved;
            }
            Object evaluateValue = resolver.evaluate(resolved, new BeanExpressionContext(beanFactory, null));
            if (evaluateValue != null) {
                return String.valueOf(evaluateValue);
            }
            return null;
        }
        return value;
    }

    @Override
    public void setEnvironment(@NotNull Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(@NotNull ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
