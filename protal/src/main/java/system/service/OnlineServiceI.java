package system.service;

import system.pageModel.DataGrid;
import system.pageModel.Online;

public abstract interface OnlineServiceI
{
  public abstract void saveOrUpdateTonlineByLoginNameAndIp(String paramString1, String paramString2);
  
  public abstract void deleteTonlineByLoginNameAndIp(String paramString1, String paramString2);
  
  public abstract DataGrid datagrid(Online paramOnline);
}


/* Location:              /Users/seven.chen/Desktop/protal.war!/WEB-INF/classes/system/service/OnlineServiceI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */