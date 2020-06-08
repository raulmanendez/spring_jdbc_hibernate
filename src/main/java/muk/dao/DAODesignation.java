package muk.dao;

import java.util.List;
import muk.beans.Designation;

public interface DAODesignation {
	void add_designation(Designation desig);
	void delete_designation(int desig_id);
	List<Designation> getAllDesignations();
}
