import java.util.UUID;

class UUIDGenerator{
    private UUID uuid;

    public UUIDGenerator(){
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String uuidToString() {
        return this.uuid.toString();
    }

    // public static void main(String[] args){
    //     UUIDGenerator uuidObj = new UUIDGenerator();
    //     System.out.println("my uuid: " + uuidObj.getUuid());
    //     System.out.println("my uuid to string: " + uuidObj.uuidToString());

    // }
}