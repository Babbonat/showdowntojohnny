public enum MetLocations
{
    NONE("None", 0),
    A_CRYSTAL_CAVERN("A Crystal Cavern", 30024),
    A_DISTANT_LAND("A Distant Land", 30007),
    A_PICNIC("A Picnic", 30023),
    ALFORNADA("Alfornada", 96),
    ALFORNADA_CAVERN("Alfornada Cavern", 67),
    AREA_ZERO_1("Area Zero (1)", 110),
    AREA_ZERO_2("Area Zero (2)", 112),
    AREA_ZERO_3("Area Zero (3)", 114),
    AREA_ZERO_4("Area Zero (4)", 116),
    AREA_ZERO_5("Area Zero (5)", 124),
    AREA_ZERO_6("Area Zero (6)", 126),
    AREA_ZERO_7("Area Zero (7)", 128),
    ARTAZON("Artazon", 86),
    ASADO_DESERT("Asado Desert", 24),
    CABO_POCO("Cabo Poco", 80),
    CAPH_SQUADS_BASE("Caph Squad’s Base", 99),
    CASCARRAFA("Cascarrafa", 76),
    CASSEROYA_LAKE_1("Casseroya Lake (1)", 40),
    CASSEROYA_LAKE_2("Casseroya Lake (2)", 108),
    CORTONDO("Cortondo", 84),
    DALIZAPA_PASSAGE("Dalizapa Passage", 69),
    EAST_PALDEAN_SEA("East Paldean Sea", 60),
    EAST_PROVINCE_AREA_ONE_1("East Province (Area One) (1)", 34),
    EAST_PROVINCE_AREA_ONE_2("East Province (Area One) (2)", 104),
    EAST_PROVINCE_AREA_TWO("East Province (Area Two)", 36),
    EAST_PROVINCE_AREA_THREE("East Province (Area Three)", 32),
    FARAWAY_PLACE("Faraway Place", 4),
    GLASEADO_MOUNTAIN_1("Glaseado Mountain (1)", 38),
    GLASEADO_MOUNTAIN_2("Glaseado Mountain (2)", 42),
    GLASEADO_MOUNTAIN_3("Glaseado Mountain (3)", 68),
    GREAT_CRATER_OF_PALDEA("Great Crater of Paldea", 50),
    INLET_GROTTO("Inlet Grotto", 64),
    LEVINCIA("Levencia", 78),
    LOS_PLATOS("Los Platos", 82),
    MEDALI("Medali", 90),
    MESAGOZA_1("Mesagoza (1)", 8),
    MESAGOZA_2("Mesagoza (2)", 72),
    MESAGOZA_3("Mesagoza (3)", 74),
    MONTEVERA("Montevera", 94),
    MYSTERY_ZONE("Mystery Zone", 2),
    NARANJA_ACADEMY("Naranja Academy", 130),
    NAVI_SQUADS_BASE("Navi Squad’s Base", 107),
    NORTH_PALDEAN_SEA("North Paldean Sea", 62),
    NORTH_PROVINCE_AREA_ONE("North Province (Area One)", 46),
    NORTH_PROVINCE_AREA_THREE_1("North Province (Area Three) (1)", 44),
    NORTH_PROVINCE_AREA_THREE_2("North Province (Area Three) (2)", 102),
    NORTH_PROVINCE_AREA_TWO("North Province (Area Two)", 48),
    NORTH_PROVINCE_AREA_TWO_2("North Province (Area Two) (2)", 98),
    POCO_PATH("Poco Path", 70),
    POKEMON_LEAGUE("Pokémon League", 10),
    PORTO_MARINADA("Porto Marinada", 88),
    RESEARCH_STATION_NO_1("Research Station No.1", 111),
    RESEARCH_STATION_NO_2("Research Station No.2", 113),
    RESEARCH_STATION_NO_3("Research Station No.3", 115),
    RESEARCH_STATION_NO_4("Research Station No.4", 117),
    RUCHBAH_SQUADS_BASE("Ruchbah Squad’s Base", 103),
    SCHEDAR_SQUADS_BASE("Schedar Squad’s Base", 105),
    SEGIN_SQUADS_BASE("Segin Squad’s Base", 101),
    SOCARRAT_TRAIL("Socarrat Trail", 109),
    SOUTH_PALDEAN_SEA("South Paldean Sea", 56),
    SOUTH_PROVINCE_AREA_FIVE("South Province (Area Five)", 18),
    SOUTH_PROVINCE_AREA_FOUR("South Province (Area Four)", 14),
    SOUTH_PROVINCE_AREA_ONE("South Province (Area One)", 6),
    SOUTH_PROVINCE_AREA_SIX_1("South Province (Area Six) (1)", 16),
    SOUTH_PROVINCE_AREA_SIX_2("South Province (Area Six) (2)", 66),
    SOUTH_PROVINCE_AREA_THREE("South Province (Area Three)", 20),
    SOUTH_PROVINCE_AREA_TWO("South Province (Area Two)", 12),
    TAGTREE_THICKET_1("Tagtree Thicket (1)", 30),
    TAGTREE_THICKET_2("Tagtree Thicket (2)", 106),
    UVA_ACADEMY("Uva Academy", 131),
    WEST_PALDEAN_SEA("West Paldean Sea", 58),
    WEST_PROVINCE_AREA_ONE_1("West Province (Area One) (1)", 22),
    WEST_PROVINCE_AREA_THREE("West Province (Area Three)", 28),
    WEST_PROVINCE_AREA_TWO("West Province (Area Two)", 26),
    ZAPAPICO("Zapapico", 92),
    ZERO_GATE_1("Zero Gate (1)", 52),
    ZERO_GATE_2("Zero Gate (2)", 54),
    ZERO_LAB_1("Zero Lab (1)", 118),
    ZERO_LAB_2("Zero Lab (2)", 120),
    ZERO_LAB_3("Zero Lab (3)", 122);

    private String name;
    private int code;

    MetLocations(String location, int value) {
        this.name = location;
        this.code = value;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return ".Met_Location="+code;
    }
}
