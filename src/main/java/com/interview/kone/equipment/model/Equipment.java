package com.interview.kone.equipment.model;

public class Equipment {

	/** 
	 * For Post request.
	 */
	private String _rev;

	/** 
	 * For Post request
	 */
	private String _id;
	
	//private String equipmentNumber;
	private String address;
	private String contractStartDate;
	private String contractEndDate;
	private boolean status;


	public String get_id() {
		return _id;
	}
	public void set_id(String id) {
		this._id = id;
	}

	public String get_rev() {
		return _rev;
	}
	public void set_rev(String rev) {
		this._rev = rev;
	}

	/*public String getEquipmentNumber() {
		return equipmentNumber;
	}
	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}*/
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContractStartDate() {
		return contractStartDate;
	}
	public void setContractStartDate(String contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	public String getContractEndDate() {
		return contractEndDate;
	}
	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
