
Feature: Physicians actions by Admin


  Background: Admin Log In

    Given user goes the login page
    When admin types the username "username"
    When admin types the password "password"
    And user clicks sign in button
#    Then user clicks the items and titles dropdown
    And user goes to Physician page

#  And user goes to Physician page

  @AdminCreatePhysicianBySSN
  Scenario: TC01_Admin_can_choose_an_existing_person_by_SSN_and_provide_some_datas
#    Scenario: TC03_Admin_should_provide_a_speciality_for_the_doctor
#    TC04_Admin_can_provide_a_profile_picture_of_the_doctor
#    TC05_Admin_should_choose_the_doctor_among_existing_users
#    TC06_Admin_should_provide_the_exam_fee_of_the_doctor

    And user clicks Create a New Physician button
    And user clicks the use search button
    And user validates the firstname and lastname of written ssn
    And user provides other info
#    birth date phone address gender blood group country state
    And user chooses a speciality for physicians
    And user provides profile picture
    And user types an exam fee
    And user choose a user from existing users
    Then user clicks the save button to saving changes


#    doktor olustururken ssn inini arastirarak daha once olusturdugumuz user(patient,user,admin) i doktor yapabiliyoruz
#    ama ssn ile arattigimiz userin "user management" page deki role u degismiyor.
#    bir ssn search etme vasitasiyla yalniz bi kere physician olusturabiliyoruz. ikinciye internal server error veriyor
#    doktoru phsicians sayfasindan olusturdugum icin user sayfasinda yok. dolayisiyla ssn ile aratamiyorum
#  burdan anladigim, ssn ile arattigimiz user in bazi bilgileri import oluyor.(firstname and lastname)
# ayni ssn ile tekrar search yapip yeni bi physician olusturmak istedigimizde internal server error veriyor.(baska zaman bi daha dene)
#  onlarin populated olmasini ariyor anladigim kadariyla?

@AdminViewPhysician
  Scenario:TC02_Admin_can_view_all_Physician's_info_populated_on_view_portal

     Given user navigate to fourth page
     And user clicks the view button for doctor
     Then validate the all info of Physician
#    id,ssn,firstname,lastname, birthdate,phone, gender,blood group, address, speciality,exam fee, description, image, user, country, state

@AdminEditPhysician
  Scenario:TC03_Admin_can_edit_existing_Physicians'_info_using_new_data

    Given user navigate to fourth page
    And user clicks the edit button for doctor
    When user edit all info and click save button
    Then validate all info has changed

  @AdminDeletePhysician
  Scenario: TC04_Admin_can_delete_existing_Physicians

    Given user navigate to fourth page
    And user clicks the delete button for doctor
    Then validate the doctor has been deleted











