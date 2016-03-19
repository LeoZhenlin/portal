package system.dao.impl;

import org.springframework.stereotype.Repository;
import system.dao.OnlineDaoI;
import system.model.Tonline;

@Repository("onlineDao")
public class OnlineDaoImpl
  extends BaseDaoImpl<Tonline>
  implements OnlineDaoI
{}


/* Location:              /Users/seven.chen/Desktop/protal.war!/WEB-INF/classes/system/dao/impl/OnlineDaoImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */