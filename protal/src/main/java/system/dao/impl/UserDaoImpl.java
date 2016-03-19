package system.dao.impl;

import org.springframework.stereotype.Repository;

import system.dao.UserDaoI;
import system.model.Tuser;

@Repository
public class UserDaoImpl extends BaseDaoImpl<Tuser> implements UserDaoI {

}
