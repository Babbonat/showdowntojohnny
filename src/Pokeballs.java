public enum Pokeballs
{
    POKEBALL("Poke Ball", "icons/pokeball.png"),
    GREATBALL("Great Ball", "icons/greatball.png"),
    ULTRABALL("Ultra Ball", "icons/ultraball.png"),
    MASTERBALL("Master Ball", "icons/masterball.png"),
    SAFARIBALL("Safari Ball", "icons/safariball.png"),
    LEVELBALL("Level Ball", "icons/levelball.png"),
    LUREBALL("Lure Ball", "icons/lureball.png"),
    MOONBALL("Moon Ball", "icons/moonball.png"),
    FRIENDBALL("Friend Ball", "icons/friendball.png"),
    LOVEBALL("Love Ball", "icons/loveball.png"),
    HEAVYBALL("Heavy Ball", "icons/heavyball.png"),
    FASTBALL("Fast Ball", "icons/fastball.png"),
    PREMIERBALL("Premier Ball", "icons/premierball.png"),
    REPEATBALL("Repeat Ball", "icons/repeatball.png"),
    TIMERBALL("Timer Ball", "icons/timerball.png"),
    NESTBALL("Nest Ball", "icons/nestball.png"),
    NETBALL("Net Ball", "icons/netball.png"),
    DIVEBALL("Dive Ball", "icons/diveball.png"),
    LUXURYBALL("Luxury Ball", "icons/luxuryball.png"),
    HEALBALL("Heal Ball", "icons/healball.png"),
    QUICKBALL("Quick Ball", "icons/quickball.png"),
    DUSKBALL("Dusk Ball", "icons/duskball.png"),
    DREAMBALL("Dream Ball", "icons/dreamball.png"),
    BEASTBALL("Beast Ball", "icons/beastball.png"),
    L_POKEBALL("Poke Ball", "icons/pokeballlegends.png"),
    L_GREATBALL("Great Ball", "icons/greatballlegends.png"),
    L_ULTRABALL("Ultra Ball", "icons/ultraballlegends.png"),
    L_HEAVYBALL("Heavy Ball", "icons/heavyballlegends.png"),
    LEADENBALL("Leaden Ball", "icons/leadenball.png"),
    GIGATONBALL("Gigaton Ball", "icons/gigatonball.png"),
    FEATHERBALL("Feather Ball", "icons/featherball.png"),
    WINGBALL("Wing Ball", "icons/wingball.png"),
    JETBALL("Jet Ball", "icons/jetball.png");
    private String name;
    private String path;

    Pokeballs(String name, String path)
    {
        this.name = name;
        this.path = path;
    }

    public String getName()
    {
        return name;
    }

    public String getPath()
    {
        return path;
    }
}
