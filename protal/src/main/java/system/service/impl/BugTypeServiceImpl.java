package system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.dao.BugTypeDaoI;
import system.model.Tbugtype;
import system.service.BugTypeServiceI;

@Service
public class BugTypeServiceImpl implements BugTypeServiceI {

	@Autowired
	private BugTypeDaoI bugType;

	@Override
	public List<Tbugtype> getBugTypeList() {
		return bugType.find("from Tbugtype t");
	}

}
