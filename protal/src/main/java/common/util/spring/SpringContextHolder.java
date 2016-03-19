/*    */ package common.util.spring;
/*    */ 
/*    */ import org.springframework.beans.BeansException;
/*    */ import org.springframework.context.ApplicationContext;
/*    */ import org.springframework.context.ApplicationContextAware;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpringContextHolder
/*    */   implements ApplicationContextAware
/*    */ {
/*    */   private static ApplicationContext applicationContext;
/*    */   
/*    */   public void setApplicationContext(ApplicationContext applicationContext)
/*    */     throws BeansException
/*    */   {
/* 26 */     SpringContextHolder.applicationContext = applicationContext;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static ApplicationContext getApplicationContext()
/*    */   {
/* 35 */     checkApplicationContext();
/* 36 */     return applicationContext;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static <T> T getBean(String name)
/*    */   {
/* 47 */     checkApplicationContext();
/* 48 */     return (T)applicationContext.getBean(name);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static <T> T getBean(Class<T> clazz)
/*    */   {
/* 59 */     checkApplicationContext();
/* 60 */     return (T)applicationContext.getBean(clazz);
/*    */   }
/*    */   
/*    */   private static void checkApplicationContext() {
/* 64 */     if (applicationContext == null) {
/* 65 */       throw new IllegalStateException("applicaitonContext未注入,请在application-context.xml中定义SpringContextHolder");
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/seven.chen/Desktop/protal.war!/WEB-INF/classes/common/util/spring/SpringContextHolder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */