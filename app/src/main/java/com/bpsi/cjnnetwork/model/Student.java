package com.bpsi.cjnnetwork.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class to represent single sponsor
 * 
 * @author pramod.shelke
 * 
 */
public class Student {

	private int userid;

	@SerializedName("id")
	@Expose
	private int id;
	@SerializedName("Stud_Member_Id")
	@Expose
	private String MemberId;
	@SerializedName("group_mnemonic")
	@Expose
	private String group_mnemonic;
	@SerializedName("Roll_no")
	@Expose
	private String rollNo;
	@SerializedName("std_PRN")
	@Expose
	private String S_PRN;
	@SerializedName("std_complete_name")
	@Expose
	private String Name;
	@SerializedName("std_name")
	@Expose
	private String FName;
	@SerializedName("std_lastname")
	@Expose
	private String LName;
	@SerializedName("std_Father_name")
	@Expose
	private String MName;

	@SerializedName("std_complete_father_name")
	@Expose
	private Object stdCompleteFatherName;
	@SerializedName("std_dob")
	@Expose
	private String dob;
	@SerializedName("old_std_dob")
	@Expose
	private String oldStdDob;
	@SerializedName("std_age")
	@Expose
	private String age;
	@SerializedName("std_school_name")
	@Expose
	private String Schoolname;
	@SerializedName("school_id")
	@Expose
	private String SchoolId;
	@SerializedName("sc_staff_id")
	@Expose
	private Object scStaffId;
	@SerializedName("std_branch")
	@Expose
	private String Branch;
	@SerializedName("std_dept")
	@Expose
	private String Dept;
	@SerializedName("std_year")
	@Expose
	private String YEAR;
	@SerializedName("std_semester")
	@Expose
	private String Semester;
	@SerializedName("std_class")
	@Expose
	private String ClassName;
	@SerializedName("Specialization")
	@Expose
	private String specialization;
	@SerializedName("std_address")
	@Expose
	private String address;
	@SerializedName("std_city")
	@Expose
	private String City;
	@SerializedName("std_country")
	@Expose
	private String country;
	@SerializedName("country_code")
	@Expose
	private String country_code;
	@SerializedName("std_gender")
	@Expose
	private String gender;
	@SerializedName("std_div")
	@Expose
	private String DivName;
	@SerializedName("std_hobbies")
	@Expose
	private String User_Hobbies;
	@SerializedName("std_classteacher_name")
	@Expose
	private String stdClassteacherName;
	@SerializedName("std_img_path")
	@Expose
	private String Imagepath;
	@SerializedName("std_email")
	@Expose
	private String emailid;
	@SerializedName("std_username")
	@Expose
	private String User_Name;
	@SerializedName("std_password")
	@Expose
	private String Password;
	@SerializedName("std_date")
	@Expose
	private String stdDate;
	@SerializedName("old_std_date")
	@Expose
	private String oldStdDate;
	@SerializedName("parent_id")
	@Expose
	private String parentId;
	@SerializedName("latitude")
	@Expose
	private String latitude;
	@SerializedName("longitude")
	@Expose
	private String longitude;
	@SerializedName("std_phone")
	@Expose
	private String phone;
	@SerializedName("std_state")
	@Expose
	private String State;
	@SerializedName("used_blue_points")
	@Expose
	private String usedBluePoints;
	@SerializedName("balance_bluestud_points")
	@Expose
	private String balanceBluestudPoints;
	@SerializedName("balance_water_points")
	@Expose
	private String balanceWaterPoints;
	@SerializedName("batch_id")
	@Expose
	private Object batchId;
	@SerializedName("error_records")
	@Expose
	private Object errorRecords;
	@SerializedName("send_unsend_status")
	@Expose
	private String sendUnsendStatus;
	@SerializedName("email_status")
	@Expose
	private String emailStatus;
	@SerializedName("Temp_address")
	@Expose
	private String tempAddress;
	@SerializedName("permanent_address")
	@Expose
	private String permanentAddress;
	@SerializedName("Permanent_village")
	@Expose
	private String permanentVillage;
	@SerializedName("Permanent_taluka")
	@Expose
	private String permanentTaluka;
	@SerializedName("Permanent_district")
	@Expose
	private String permanentDistrict;
	@SerializedName("Permanent_pincode")
	@Expose
	private String permanentPincode;
	@SerializedName("Email_Internal")
	@Expose
	private String emailInternal;
	@SerializedName("Admission_year_id")
	@Expose
	private Object admissionYearId;
	@SerializedName("Academic_Year")
	@Expose
	private String academicYear;
	@SerializedName("Course_level")
	@Expose
	private String Courcelevel;
	@SerializedName("Iscoordinator")
	@Expose
	private String Iscoordinator = "N";
	@SerializedName("Gcm_id")
	@Expose
	private Object gcmId;
	@SerializedName("college_mnemonic")
	@Expose
	private String collegeMnemonic;
	@SerializedName("ExtBranchId")
	@Expose
	private Object extBranchId;
	@SerializedName("ExtDeptId")
	@Expose
	private Object extDeptId;
	@SerializedName("ExtSemesterId")
	@Expose
	private Object extSemesterId;
	@SerializedName("validity")
	@Expose
	private Object validity;
	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("uploaded_by")
	@Expose
	private String uploadedBy;
	@SerializedName("upload_date")
	@Expose
	private String uploadDate;
	@SerializedName("fb_id")
	@Expose
	private Object fbId;
	@SerializedName("gplus_id")
	@Expose
	private Object gplusId;
	@SerializedName("linkedin_id")
	@Expose
	private Object linkedinId;
	@SerializedName("RegistrationSource")
	@Expose
	private String registrationSource;
	@SerializedName("email_time_log")
	@Expose
	private String emailTimeLog;
	@SerializedName("sms_time_log")
	@Expose
	private String smsTimeLog;
	@SerializedName("group_status")
	@Expose
	private String groupStatus;
	@SerializedName("sms_response")
	@Expose
	private String smsResponse;
	@SerializedName("group_member_id")
	@Expose
	private String groupMemberId;

	@SerializedName("green")
	@Expose
	private String green;

	@SerializedName("is_accept_terms")
	@Expose
	private String is_accept_terms;


	@SerializedName("tnc_link")
	@Expose
	private String tnc_link;

		public Student(int id, int userid, String password, String name, String FName, String MName,
                       String LName, String address, String city, String dob, String age, String gender,
                       String country, String state, String schoolname, String schoolId, String s_PRN,
                       String emailid, String phone, String className, String divName, String YEAR,
                       String branch, String dept, String semester, String courcelevel, String imagepath,
                       String user_Name, String user_Hobbies, String iscoordinator,
                       String memberId, String country_code, String status, String green) {
		this.id = id;
		this.userid = userid;
		this.Password = password;
		this.Name = name;
		this.FName = FName;
		this.MName = MName;
		this.LName = LName;
		this.Schoolname = schoolname;
		this.SchoolId = schoolId;
		this.S_PRN = s_PRN;
		this.emailid = emailid;
		this.phone = phone;
		this.ClassName = className;
		this.DivName = divName;
		this.address = address;
		this.City = city;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.country = country;
		this.State = state;
		this.YEAR = YEAR;
		this.Branch = branch;
		this.Dept = dept;
		this.Semester = semester;
		this.Courcelevel = courcelevel;
		this.Imagepath = imagepath;
		this.User_Name = user_Name;
		this.User_Hobbies = user_Hobbies;
		this.Iscoordinator = iscoordinator;
		this.MemberId = memberId;
		this.country_code = country_code;
		this.status = status;
		this.green = green;
	}


		public Student(int id, int userid, String Password, String Name, String FName, String MName, String LName, String address, String City , String dob , String age , String gender ,
                       String country, String State , String Schoolname, String SchoolId,
                       String S_PRN, String emailid, String phone, String ClassName, String DivName, String YEAR,
                       String Branch, String Dept, String Semester, String Courcelevel, String Imagepath,
                       String User_Name, String User_Hobbies, String country_code) {
		this.id=id;
	    this.userid=userid;
		this.Password=Password;
		this.Name=Name;
		this.FName=FName;
		this.MName=MName;
		this.LName=LName;
		this.address  =address;
		this.City =City;
	    this.dob = dob;
		this.age=age;
		this.gender = gender;
	    this.country = country;
		this.State = State;
		this.Schoolname=Schoolname;
		this.SchoolId=SchoolId;
	    this.S_PRN=S_PRN;
		this.emailid=emailid;
		this.phone=phone;
	    this.ClassName=ClassName;
		this.DivName=DivName;
		this.User_Name=User_Name;
		this.User_Hobbies=User_Hobbies;
	    this.YEAR=YEAR;
		this.Branch=Branch;
		this.Dept=Dept;
	    this.Semester=Semester;
		this.Courcelevel=Courcelevel;
		this.Imagepath=Imagepath;
			this.country_code = country_code;
	}

	public String getIs_accept_terms() {
		return is_accept_terms;
	}

	public void setIs_accept_terms(String is_accept_terms) {
		this.is_accept_terms = is_accept_terms;
	}

	public String getTnc_link() {
		return tnc_link;
	}

	public void setTnc_link(String tnc_link) {
		this.tnc_link = tnc_link;
	}

	public String getGreen() {
		return green;
	}

	public void setGreen(String green) {
		this.green = green;
	}

	public int getId() {
		return id;
	}

	public int getUserid() {
		return userid;
	}

	public String getPassword() {
		return Password;
	}

	public String getName() {
		return Name;
	}

	public String getFName() {
		return FName;
	}

	public String getMName() {
		return MName;
	}

	public String getLName() {
		return LName;
	}

	public String getSchoolname() {
		return Schoolname;
	}

	public String getSchoolId() {
		return SchoolId;
	}

	public String getS_PRN() {
		return S_PRN;
	}

	public String getEmailid() {
		return emailid;
	}

	public String getPhone() {
		return phone;
	}



	public String getClassName() {
		return ClassName;
	}

	public String getDivName() {
		return DivName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return City;
	}

	public String getDob() {
		return dob;
	}

	public String getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return State;
	}

	public String getYEAR() {
		return YEAR;
	}

	public String getBranch() {
		return Branch;
	}

	public String getDept() {
		return Dept;
	}

	public String getSemester() {
		return Semester;
	}

	public String getCourcelevel() {
		return Courcelevel;
	}

	public String getImagepath() {
		return Imagepath;
	}

	public String getUser_Name() {
		return User_Name;
	}

	public String getUser_Hobbies() {
		return User_Hobbies;
	}

	public String getIscoordinator() {
		return Iscoordinator;
	}

	/*public String  getMemberID() {

		String str1 =String.valueOf(userid);
		return str1;
	}*/

	public String getCountry_code() {
		return country_code;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

	public void setMName(String MName) {
		this.MName = MName;
	}

	public void setLName(String LName) {
		this.LName = LName;
	}

	public void setSchoolname(String schoolname) {
		Schoolname = schoolname;
	}

	public void setSchoolId(String schoolId) {
		SchoolId = schoolId;
	}

	public void setS_PRN(String s_PRN) {
		S_PRN = s_PRN;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public void setDivName(String divName) {
		DivName = divName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		City = city;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setState(String state) {
		State = state;
	}

	public void setYEAR(String YEAR) {
		this.YEAR = YEAR;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public void setDept(String dept) {
		Dept = dept;
	}

	public void setSemester(String semester) {
		Semester = semester;
	}

	public void setCourcelevel(String courcelevel) {
		Courcelevel = courcelevel;
	}

	public void setImagepath(String imagepath) {
		Imagepath = imagepath;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}

	public void setUser_Hobbies(String user_Hobbies) {
		User_Hobbies = user_Hobbies;
	}

	public void setIscoordinator(String iscoordinator) {
		Iscoordinator = iscoordinator;
	}

	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public void setCountry_code(String Country_code) {
		Country_code = Country_code;
	}

	public String getMemberId() {
		return MemberId;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Object getStdCompleteFatherName() {
		return stdCompleteFatherName;
	}

	public void setStdCompleteFatherName(Object stdCompleteFatherName) {
		this.stdCompleteFatherName = stdCompleteFatherName;
	}

	public String getOldStdDob() {
		return oldStdDob;
	}

	public void setOldStdDob(String oldStdDob) {
		this.oldStdDob = oldStdDob;
	}

	public Object getScStaffId() {
		return scStaffId;
	}

	public void setScStaffId(Object scStaffId) {
		this.scStaffId = scStaffId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getStdClassteacherName() {
		return stdClassteacherName;
	}

	public void setStdClassteacherName(String stdClassteacherName) {
		this.stdClassteacherName = stdClassteacherName;
	}

	public String getStdDate() {
		return stdDate;
	}

	public void setStdDate(String stdDate) {
		this.stdDate = stdDate;
	}

	public String getOldStdDate() {
		return oldStdDate;
	}

	public void setOldStdDate(String oldStdDate) {
		this.oldStdDate = oldStdDate;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getUsedBluePoints() {
		return usedBluePoints;
	}

	public void setUsedBluePoints(String usedBluePoints) {
		this.usedBluePoints = usedBluePoints;
	}

	public String getBalanceBluestudPoints() {
		return balanceBluestudPoints;
	}

	public void setBalanceBluestudPoints(String balanceBluestudPoints) {
		this.balanceBluestudPoints = balanceBluestudPoints;
	}

	public String getBalanceWaterPoints() {
		return balanceWaterPoints;
	}

	public void setBalanceWaterPoints(String balanceWaterPoints) {
		this.balanceWaterPoints = balanceWaterPoints;
	}

	public Object getBatchId() {
		return batchId;
	}

	public void setBatchId(Object batchId) {
		this.batchId = batchId;
	}

	public Object getErrorRecords() {
		return errorRecords;
	}

	public void setErrorRecords(Object errorRecords) {
		this.errorRecords = errorRecords;
	}

	public String getSendUnsendStatus() {
		return sendUnsendStatus;
	}

	public void setSendUnsendStatus(String sendUnsendStatus) {
		this.sendUnsendStatus = sendUnsendStatus;
	}

	public String getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getTempAddress() {
		return tempAddress;
	}

	public void setTempAddress(String tempAddress) {
		this.tempAddress = tempAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPermanentVillage() {
		return permanentVillage;
	}

	public void setPermanentVillage(String permanentVillage) {
		this.permanentVillage = permanentVillage;
	}

	public String getPermanentTaluka() {
		return permanentTaluka;
	}

	public void setPermanentTaluka(String permanentTaluka) {
		this.permanentTaluka = permanentTaluka;
	}

	public String getPermanentDistrict() {
		return permanentDistrict;
	}

	public void setPermanentDistrict(String permanentDistrict) {
		this.permanentDistrict = permanentDistrict;
	}

	public String getPermanentPincode() {
		return permanentPincode;
	}

	public void setPermanentPincode(String permanentPincode) {
		this.permanentPincode = permanentPincode;
	}

	public String getEmailInternal() {
		return emailInternal;
	}

	public void setEmailInternal(String emailInternal) {
		this.emailInternal = emailInternal;
	}

	public Object getAdmissionYearId() {
		return admissionYearId;
	}

	public void setAdmissionYearId(Object admissionYearId) {
		this.admissionYearId = admissionYearId;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public Object getGcmId() {
		return gcmId;
	}

	public void setGcmId(Object gcmId) {
		this.gcmId = gcmId;
	}

	public String getCollegeMnemonic() {
		return collegeMnemonic;
	}

	public void setCollegeMnemonic(String collegeMnemonic) {
		this.collegeMnemonic = collegeMnemonic;
	}

	public Object getExtBranchId() {
		return extBranchId;
	}

	public void setExtBranchId(Object extBranchId) {
		this.extBranchId = extBranchId;
	}

	public Object getExtDeptId() {
		return extDeptId;
	}

	public void setExtDeptId(Object extDeptId) {
		this.extDeptId = extDeptId;
	}

	public Object getExtSemesterId() {
		return extSemesterId;
	}

	public void setExtSemesterId(Object extSemesterId) {
		this.extSemesterId = extSemesterId;
	}

	public Object getValidity() {
		return validity;
	}

	public void setValidity(Object validity) {
		this.validity = validity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Object getFbId() {
		return fbId;
	}

	public void setFbId(Object fbId) {
		this.fbId = fbId;
	}

	public Object getGplusId() {
		return gplusId;
	}

	public void setGplusId(Object gplusId) {
		this.gplusId = gplusId;
	}

	public Object getLinkedinId() {
		return linkedinId;
	}

	public void setLinkedinId(Object linkedinId) {
		this.linkedinId = linkedinId;
	}

	public String getRegistrationSource() {
		return registrationSource;
	}

	public void setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
	}

	public String getEmailTimeLog() {
		return emailTimeLog;
	}

	public void setEmailTimeLog(String emailTimeLog) {
		this.emailTimeLog = emailTimeLog;
	}

	public String getSmsTimeLog() {
		return smsTimeLog;
	}

	public void setSmsTimeLog(String smsTimeLog) {
		this.smsTimeLog = smsTimeLog;
	}

	public String getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus;
	}

	public String getSmsResponse() {
		return smsResponse;
	}

	public void setSmsResponse(String smsResponse) {
		this.smsResponse = smsResponse;
	}

	public String getGroupMemberId() {
		return groupMemberId;
	}

	public void setGroupMemberId(String groupMemberId) {
		this.groupMemberId = groupMemberId;
	}

	public String getGroup_mnemonic() {
		return group_mnemonic;
	}

	public void setGroup_mnemonic(String group_mnemonic) {
		this.group_mnemonic = group_mnemonic;
	}
}
