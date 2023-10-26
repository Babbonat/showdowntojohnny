public enum Games
{
    SV("SV","#"),
    SWOSHI("SWOSHI","$"),
    PLA("PLA","%"),
    BDSP("BDSP","!");

    String name;
    String prefix;

    Games(String name, String prefix)
    {
        this.name = name;
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }
}
