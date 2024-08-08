class EmailService{
    private String serviceName;

    public EmailService(String serviceName){
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void sendRegMail(String toAddress, String uuid) {
        System.out.println("Admin message: Sending registration email to " + toAddress);
        System.out.println("Patient message: Dear user, your UUID is: " + uuid);
    }

    public static void main(String[] args) {
        EmailService mailObj = new EmailService("User Registration");

        //generate uuid 
        UUIDGenerator uuidGenObj = new UUIDGenerator(); 

        String uuid = uuidGenObj.uuidToString(); 

        System.out.println(mailObj.getServiceName());
        System.out.println("Sending email simulation");
        mailObj.sendRegMail("patient@gmail.com", uuid);
    }
}