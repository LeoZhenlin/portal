/*    */ package system.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ import javax.persistence.Temporal;
/*    */ import javax.persistence.TemporalType;
/*    */ import org.hibernate.annotations.DynamicInsert;
/*    */ import org.hibernate.annotations.DynamicUpdate;
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
/*    */ @Entity
/*    */ @Table(name="TONLINE", schema="")
/*    */ @DynamicInsert(true)
/*    */ @DynamicUpdate(true)
/*    */ public class Tonline
/*    */   implements Serializable
/*    */ {
/*    */   private String id;
/*    */   private String loginname;
/*    */   private String ip;
/*    */   private Date logindatetime;
/*    */   
/*    */   public Tonline() {}
/*    */   
/*    */   public Tonline(String id, String loginname, String ip, Date logindatetime)
/*    */   {
/* 39 */     this.id = id;
/* 40 */     this.loginname = loginname;
/* 41 */     this.ip = ip;
/* 42 */     this.logindatetime = logindatetime;
/*    */   }
/*    */   
/*    */   @Id
/*    */   @Column(name="ID", nullable=false, length=36)
/*    */   public String getId()
/*    */   {
/* 49 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 53 */     this.id = id;
/*    */   }
/*    */   
/*    */   @Column(name="LOGINNAME", nullable=false, length=100)
/*    */   public String getLoginname() {
/* 58 */     return this.loginname;
/*    */   }
/*    */   
/*    */   public void setLoginname(String loginname) {
/* 62 */     this.loginname = loginname;
/*    */   }
/*    */   
/*    */   @Column(name="IP", nullable=false, length=50)
/*    */   public String getIp() {
/* 67 */     return this.ip;
/*    */   }
/*    */   
/*    */   public void setIp(String ip) {
/* 71 */     this.ip = ip;
/*    */   }
/*    */   
/*    */   @Temporal(TemporalType.TIMESTAMP)
/*    */   @Column(name="LOGINDATETIME", nullable=false, length=7)
/*    */   public Date getLogindatetime() {
/* 77 */     return this.logindatetime;
/*    */   }
/*    */   
/*    */   public void setLogindatetime(Date logindatetime) {
/* 81 */     this.logindatetime = logindatetime;
/*    */   }
/*    */ }


/* Location:              /Users/seven.chen/Desktop/protal.war!/WEB-INF/classes/system/model/Tonline.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */