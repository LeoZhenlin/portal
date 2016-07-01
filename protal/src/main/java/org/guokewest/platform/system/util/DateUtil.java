/*    */ package org.guokewest.platform.system.util;
/*    */ 
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
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
/*    */ public class DateUtil
/*    */ {
/*    */   public static String format(Date date)
/*    */   {
/* 22 */     return format(date, "yyyy-MM-dd HH:mm:ss");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String format(Date date, String pattern)
/*    */   {
/* 35 */     if (date == null) {
/* 36 */       return "null";
/*    */     }
/* 38 */     if ((pattern == null) || (pattern.equals("")) || (pattern.equals("null"))) {
/* 39 */       pattern = "yyyy-MM-dd HH:mm:ss";
/*    */     }
/* 41 */     return new SimpleDateFormat(pattern).format(date);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Date format(String date)
/*    */   {
/* 52 */     return format(date, null);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Date format(String date, String pattern)
/*    */   {
/* 65 */     if ((pattern == null) || (pattern.equals("")) || (pattern.equals("null"))) {
/* 66 */       pattern = "yyyy-MM-dd HH:mm:ss";
/*    */     }
/* 68 */     if ((date == null) || (date.equals("")) || (date.equals("null"))) {
/* 69 */       return new Date();
/*    */     }
/* 71 */     Date d = null;
/*    */     try {
/* 73 */       d = new SimpleDateFormat(pattern).parse(date);
/*    */     }
/*    */     catch (ParseException localParseException) {}
/* 76 */     return d;
/*    */   }
/*    */ }


/* Location:              /Users/seven.chen/Desktop/protal.war!/WEB-INF/classes/org.guokewest.platform.system/util/DateUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */