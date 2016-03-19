/*    */ package system.controller;
/*    */ 
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import system.pageModel.DataGrid;
/*    */ import system.pageModel.Online;
/*    */ import system.service.OnlineServiceI;
/*    */ 
/*    */ @RequestMapping({"/onlineController"})
/*    */ @Controller
/*    */ public class OnlineController
/*    */ {
/*    */   private OnlineServiceI onlineService;
/*    */   
/*    */   public OnlineServiceI getOnlineService()
/*    */   {
/* 19 */     return this.onlineService;
/*    */   }
/*    */   
/*    */   @Autowired
/*    */   public void setOnlineService(OnlineServiceI onlineService) {
/* 24 */     this.onlineService = onlineService;
/*    */   }
/*    */   
/*    */   @RequestMapping({"/datagrid"})
/*    */   @ResponseBody
/*    */   public DataGrid datagrid(Online online) {
/* 30 */     return this.onlineService.datagrid(online);
/*    */   }
/*    */ }


/* Location:              /Users/seven.chen/Desktop/protal.war!/WEB-INF/classes/system/controller/OnlineController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */