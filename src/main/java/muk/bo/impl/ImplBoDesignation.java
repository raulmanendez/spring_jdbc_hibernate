package muk.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import muk.beans.Designation;
import muk.bo.BODesignation;
import muk.dao.DAODesignation;

@Service

public class ImplBoDesignation implements BODesignation{

	@Autowired
	private DAODesignation dao_designation;
	public void add_designation(Designation desig) {
		dao_designation.add_designation(desig);
		
	}

	public void delete_designation(int desig_id) {
		dao_designation.delete_designation(desig_id);
		
	}

	public List<Designation> getAllDesignations() {
		return dao_designation.getAllDesignations();
	}

}
