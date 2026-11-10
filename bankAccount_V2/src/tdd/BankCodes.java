package tdd;

public enum BankCodes {
    ACCESSBANK("044"),
    AFRIBANK("014"),
    CITIBANK("023"),
    DIAMONDBANK("063"),
    ECOBANK("050"),
    EQUITORIALTRUSTBANK("040"),
    FIRSTBANK("011"),
    FCMB("214"),
    FIDELITYBANK("070"),
    FINBANK("085"),
    GUARANTYTRUSTBANK("058"),
    INTERCONTINENTALBANK("069"),
    OCEANICBANK("056"),
    BANKPHB("082"),
    SKYEBANK("076"),
    SPRINGBANK("084"),
    STANBICIBTC("221"),
    STANDARDCHARTEREDBANK("068"),
    STERLINGBANK("232"),
    UNITEDBANKFORAFRIA("033"),
    UNIONBANK("032"),
    WEMABANK("035"),
    ZENITHBANK("057"),
    UNITYBANK("215");

    private String bankCode;

    BankCodes(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCode() {
        return bankCode;
    }
}

