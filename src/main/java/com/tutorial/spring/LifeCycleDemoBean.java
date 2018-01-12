package com.tutorial.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * This class demonstrates the different steps in the life cycle of a bean
 * 
 * @author Bastian Bräunel
 *
 */
@Component
public class LifeCycleDemoBean
		implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

	public LifeCycleDemoBean() {
		System.out.println("## Lifecycle - Constructor \t Der konstruktor wurde durchlaufen.");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("## Lifecycle - afterPropertiesSet \t Alle Poperties der Bean wurden gesetzt.");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("## Lifecycle - destroy \t Die Bean wird jetzt zerstört. Zeit zum aufräumen.");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("## Lifecycle - setBeanName \t Der Name der Bean wird auf [ " + name + " ] gesetzte.");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("## Lifecycle - setBeanFactory \t Die Factory der Bean wird jetzt gesetzt.");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("## Lifecycle - setApplicationContext \t Die ApplicationContext der Bean wird jetzt gesetzt.");
	}

	@PostConstruct
	public void postonstruct() {
		System.out.println("## Lifecycle - postonstruct \t Die Bean nach dem der Konstruktor durchlaufen wurde");
	}

	@PreDestroy
	public void preDrestoy() {
		System.out.println("## Lifecycle - destroy \t Ich bereite mich darauf vor die Bean zu zerstören.");
	}

	public void beforeInit() {
		System.out.println("## Lifecycle - beforeInit \t Bean vor der Initalisierung");
	}

	public void afterInit() {
		System.out.println("## Lifecycle - afterInit \t Bean nach der Initalisierung");
	}
}
