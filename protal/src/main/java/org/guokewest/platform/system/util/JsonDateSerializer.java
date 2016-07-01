/*    */ package org.guokewest.platform.system.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Date;
/*    */ import org.codehaus.jackson.JsonGenerator;
/*    */ import org.codehaus.jackson.JsonProcessingException;
/*    */ import org.codehaus.jackson.map.JsonSerializer;
/*    */ import org.codehaus.jackson.map.SerializerProvider;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class JsonDateSerializer
/*    */   extends JsonSerializer<Date>
/*    */ {
/*    */   public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
/*    */     throws IOException, JsonProcessingException
/*    */   {
/* 23 */     jsonGenerator.writeString(DateUtil.format(date));
/*    */   }
/*    */ }


/* Location:              /Users/seven.chen/Desktop/protal.war!/WEB-INF/classes/org.guokewest.platform.system/util/JsonDateSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */