package org.guokewest.platform.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.guokewest.platform.system.dao.BugTypeDaoI;
import org.guokewest.platform.system.model.Tbugtype;
import org.guokewest.platform.system.service.BugTypeServiceI;

@Service
public class BugTypeServiceImpl implements BugTypeServiceI {

	@Autowired
	private BugTypeDaoI bugType;

	@Override
	public List<Tbugtype> getBugTypeList() {
		return bugType.find("from Tbugtype t");
	}

}
