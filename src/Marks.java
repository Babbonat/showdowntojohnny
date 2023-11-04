public enum Marks
{
    NONE("None", ""),
    SPACEY("Spacey", ".RibbonMarkAbsentMinded=true"),
    FURIOUS("Furious", ".RibbonMarkAngry=true"),
    SHIVERING("Shivering", ".RibbonMarkBlizzard=true"),
    SERENE("Serene", ".RibbonMarkCalmness=true"),
    RADIANT("Radiant", ".RibbonMarkCharismatic=true"),
    CLOUD_WATCHER("Cloud Watcher", ".RibbonMarkCloudy=true"),
    OPPORTUNIST("Opportunist", ".RibbonMarkCrafty=true"),
    EARLY_RISER("Early Riser", ".RibbonMarkDawn=true"),
    CHOSEN_ONE("Chosen One", ".RibbonMarkDestiny=true"),
    PARCHED("Parched", ".RibbonMarkDry=true"),
    DOZY("Dozy", ".RibbonMarkDusk=true"),
    GIDDY("Giddy", ".RibbonMarkExcited=true"),
    RAMPAGING("Rampaging", ".RibbonMarkFerocious=true"),
    CATCH_OF_THE_DAY("Catch Of The Day", ".RibbonMarkFishing=true"),
    EASILY_FLUSTERED("Easily Flustered", ".RibbonMarkFlustered=true"),
    HUMBLE("Humble", ".RibbonMarkHumble=true"),
    SCHOLAR("Scholar", ".RibbonMarkIntellectual=true"),
    FEISTY("Feisty", ".RibbonMarkIntense=true"),
    ANXIOUS("Anxious", ".RibbonMarkJittery=true"),
    JOYFUL("Joyful", ".RibbonMarkJoyful=true"),
    KINDHEARTED("Kindhearted", ".RibbonMarkKindly=true"),
    PECKISH("Peckish", ".RibbonMarkLunchtime=true"),
    MIST_DRIFTER("Mist Drifter", ".RibbonMarkMisty=true"),
    GRUMPY("Grumpy", ".RibbonMarkPeeved=true"),
    ARROGANT("Arrogant", ".RibbonMarkPrideful=true"),
    DRIVEN("Driven", ".RibbonMarkPumpedUp=true"),
    SODDEN("Sodden", ".RibbonMarkRainy=true"),
    RECLUSE("Recluse", ".RibbonMarkRare=true"),
    ROWDY("Rowdy", ".RibbonMarkRowdy=true"),
    SANDSWEPT("Sandswept", ".RibbonMarkSandstorm=true"),
    STERN("Stern", ".RibbonMarkScowling=true"),
    SLEEPY("Sleepy", ".RibbonMarkSleepy Time=true"),
    WORN_OUT("Worn Out", ".RibbonMarkSlump=true"),
    BEAMING("Beaming", ".RibbonMarkSmiley=true"),
    SNOW_FROLICKER("Snow Frolicker", ".RibbonMarkSnowy=true"),
    THUNDERSTRUCK("Thunderstruck", ".RibbonMarkStormy=true"),
    TEARY_EYED("Teary Eyed", ".RibbonMarkTeary=true"),
    POMPOUS("Pompous", ".RibbonMarkThorny=true"),
    SOCIABLE("Sociable", ".RibbonMarkUncommon=true"),
    RELUCTANT("Reluctant", ".RibbonMarkUnsure=true"),
    CHIPPER("Chipper", ".RibbonMarkUpbeat=true"),
    LIVELY("Lively", ".RibbonMarkVigor=true"),
    APATHETIC("Apathetic", ".RibbonMarkZero Energy=true"),
    DAYDREAMER("Daydreamer", ".RibbonMarkZoned Out=true"),
    TREASURE_HUNTER("Treasure Hunter", ".RibbonMarkItemfinder=true"),
    GOURMET("Gourmet", ".RibbonMarkGourmand=true"),
    GREAT("Great", ".RibbonMarkJumbo=true"),
    UNRIVALED("Unrivaled", ".RibbonMarkMightiest=true"),
    TEENY("Teeny", ".RibbonMarkMini=true"),
    RELIABLE_PARTNER("Reliable Partner", ".RibbonMarkPartner=true"),
    FORMER_TITAN("Former Titan", ".RibbonMarkTitan=true"),
    FORMER_ALPHA("Former Alpha", ".RibbonMarkAlpha=true"),
    ONE_IN_A_MILLION("One In A Million", ".RibbonOnceInALifetime=true");


    private String name;
    private String line;

    Marks(String name, String line)
    {
        this.name = name;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public String getLine() {
        return line;
    }
}
