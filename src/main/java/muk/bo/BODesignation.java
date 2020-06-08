package muk.bo;

import java.util.List;

import muk.beans.Designation;

public interface BODesignation {
	void add_designation(Designation desig);
	void delete_designation(int desig_id);
	List<Designation> getAllDesignations();
}
