/*    */ package system.pageModel;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ import org.codehaus.jackson.map.annotate.JsonSerialize;
/*    */ import system.util.JsonDateSerializer;
/*    */ 
/*    */ public class Online
/*    */   implements Serializable
/*    */ {
/*    */   private int page;
/*    */   private int rows;
/*    */   private String sort;
/*    */   private String order;
/*    */   private String id;
/*    */   private String loginname;
/*    */   private String ip;
/*    */   private Date logindatetime;
/*    */   
/*    */   public int getPage()
/*    */   {
/* 22 */     return this.page;
/*    */   }
/*    */   
/*    */   public void setPage(int page) {
/* 26 */     this.page = page;
/*    */   }
/*    */   
/*    */   public int getRows() {
/* 30 */     return this.rows;
/*    */   }
/*    */   
/*    */   public void setRows(int rows) {
/* 34 */     this.rows = rows;
/*    */   }
/*    */   
/*    */   public String getSort() {
/* 38 */     return this.sort;
/*    */   }
/*    */   
/*    */   public void setSort(String sort) {
/* 42 */     this.sort = sort;
/*    */   }
/*    */   
/*    */   public String getOrder() {
/* 46 */     return this.order;
/*    */   }
/*    */   
/*    */   public void setOrder(String order) {
/* 50 */     this.order = order;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 54 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 58 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getLoginname() {
/* 62 */     return this.loginname;
/*    */   }
/*    */   
/*    */   public void setLoginname(String loginname) {
/* 66 */     this.loginname = loginname;
/*    */   }
/*    */   
/*    */   public String getIp() {
/* 70 */     return this.ip;
/*    */   }
/*    */   
/*    */   public void setIp(String ip) {
/* 74 */     this.ip = ip;
/*    */   }
/*    */   
/*    */   @JsonSerialize(using=JsonDateSerializer.class)
/*    */   public Date getLogindatetime() {
/* 79 */     return this.logindatetime;
/*    */   }
/*    */   
/*    */   public void setLogindatetime(Date logindatetime) {
/* 83 */     this.logindatetime = logindatetime;
/*    */   }
/*    */ }


/* Location:              /Users/seven.chen/Desktop/protal.war!/WEB-INF/classes/system/pageModel/Online.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */