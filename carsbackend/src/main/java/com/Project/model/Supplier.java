package com.Project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier {
	 @Id
	 @GeneratedValue
	 int supplierId;
	 String supplierName;
	 String supplierMobileNo;
	 String supplierMailId;
	 String supplierAddr;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierMobileNo() {
		return supplierMobileNo;
	}
	public void setSupplierMobileNo(String supplierMobileNo) {
		this.supplierMobileNo = supplierMobileNo;
	}
	public String getSupplierMailId() {
		return supplierName;
	}
	public void setSupplierMailId(String supplierMailId) {
		this.supplierMailId = supplierMailId;
	}
	public String getSupplierAddr() {
		return supplierAddr;
	}
	public void setSupplierAddr(String supplierAddr) {
		this.supplierAddr = supplierAddr;
	}

}
