package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Registrant {

    /*
        {
      "activated": true,
      "authorities": [
        "string"
      ],
      "createdBy": "string",
      "createdDate": "2022-03-06T16:16:26.333Z",
      "email": "string",
      "firstName": "string",
      "id": 0,
      "imageUrl": "string",
      "langKey": "string",
      "lastModifiedBy": "string",
      "lastModifiedDate": "2022-03-06T16:16:26.333Z",
      "lastName": "string",
      "login": "string",
      "password": "string",
      "ssn": "string"
    }
         */
    private String firstName;
    private String lastName;
    private String ssn;
    private String login;
    private String langKey;
    private String password;
    private String email;
    private String usernamet;
    private String sign;
    private String id;
    private String passwords;
    private String click;
    private String pages;
    private String searchp;
    private String SSN;
    private String show;
    private String edit;
    private String ID;
    private String startDate;
    private String endDate;
    private String status;
    private String anamnesis;
    private String treatment;
    private String editing;
    private String editingn;
    private String iD;
    private String fn;
    private String ln;
    private String birth;
    private String emailing;
    private String phone;

    public Registrant() {
    }

    public Registrant(String firstName, String lastName, String ssn, String login, String langKey, String password, String email, String usernamet, String sign, String id, String passwords, String click, String pages, String searchp, String SSN, String show, String edit, String ID, String startDate, String status, String anamnesis, String treatment, String editing, String editingn, String iD, String fn, String ln, String birth, String emailing, String phone) {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;


    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;


    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;


    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;


    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;


    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;


    }

    public String getUsernamet() {
        return usernamet;
    }

    public void setUsernamet(String usernamet) {
        this.usernamet = usernamet;


    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;


    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;


    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;


    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;


    }

    public String getSearchp() {
        return searchp;
    }

    public void setSearchp(String searchp) {
        this.searchp = searchp;


    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;


    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;


    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;


    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;


    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;


    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;


    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;


    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;


    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;


    }

    public String getEditing() {
        return editing;
    }

    public void setEditing(String editing) {
        this.editing = editing;


    }

    public String getEditingn() {
        return editingn;
    }

    public void setEditingn(String editingn) {
        this.editingn = editingn;


    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;


    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;


    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;


    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;


    }

    public String getEmailing() {
        return emailing;
    }

    public void setEmailing(String emailing) {
        this.emailing = emailing;


    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;


    }

    @Override
    public String toString() {
        return "Registrant{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", login='" + login + '\'' +
                ", langKey='" + langKey + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", usernamet='" + usernamet + '\'' +
                ", sign='" + sign + '\'' +
                ", id='" + id + '\'' +
                ", passwords='" + passwords + '\'' +
                ", click='" + click + '\'' +
                ", pages='" + pages + '\'' +
                ", searchp='" + searchp + '\'' +
                ", SSN='" + SSN + '\'' +
                ", show='" + show + '\'' +
                ", edit='" + edit + '\'' +
                ", ID='" + ID + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", anamnesis='" + anamnesis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", editing='" + editing + '\'' +
                ", editingn='" + editingn + '\'' +
                ", iD='" + iD + '\'' +
                ", fn='" + fn + '\'' +
                ", ln='" + ln + '\'' +
                ", birth='" + birth + '\'' +
                ", emailing='" + emailing + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


}





