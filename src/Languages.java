public enum Languages
{
    JAP("Japanese"),
    ENG("English"),
    FRE("French"),
    ITA("Italian"),
    GER("German"),
    ESP("Spanish"),
    KOR("Korean"),
    CHS("Chinese-semplified"),
    CHT("Chinese-traditional");

    private String language;
    Languages(String language)
    {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
