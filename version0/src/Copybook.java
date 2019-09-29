public class Copybook {
    private int level;
    private String typeName;
    private String dataType;
    private int valueLength;
    private String valueType;

    Copybook() {}

    Copybook(int level, String typeName, String dataType, int valueLength, String valueType){
        this.level = level;
        this.typeName = typeName;
        this.dataType = dataType;
        this.valueLength = valueLength;
        this.valueType = valueType;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(this.level == 0)
            this.level = level;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        if(this.typeName == null)
            this.typeName = typeName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        if(this.dataType == null)
            this.dataType = dataType;
    }

    public int getValueLength() {
        return valueLength;
    }

    public void setValueLength(int valueLength) {
        if(this.valueLength == 0)
            this.valueLength = valueLength;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        if(this.valueType == null)
            this.valueType = valueType;
    }
}
