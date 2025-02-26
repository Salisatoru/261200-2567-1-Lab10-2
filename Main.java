public class Main {
    public static void main(String[] args) {
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo("4789565874102365");
        xpay.setCustomerName("Somchai Jaidee");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short) 235);
        xpay.setAmount(2565.23);

        PayD payD = new XpayToPayDAdapter(xpay);
        testPayD(payD);
    }

    private static void testPayD(PayD payD) {
        System.out.println("Card Owner: " + payD.getCardOwnerName());
        System.out.println("Credit Card No: " + payD.getCreditCardNo());
        System.out.println("Expiry Date (MMYY): " + payD.getCardExpMonthYear());
        System.out.println("CVV No: " + payD.getCVVNo());
        System.out.println("Total Amount: " + payD.getTotalAmount());
    }
}
// เงื่อนไขที่โค้ดนี้ทำได้
//✔ ใช้ Adapter Pattern
//✔ ใช้ XpayToPayDAdapter เพื่อเชื่อมต่อ Xpay กับ PayD
//✔ ไม่สร้าง PayDImpl ตามข้อกำหนด
//✔ ใช้ Long.parseLong และ String.valueOf เพื่อแปลงค่าตามข้อกำหนด
//✔ ใช้ การรวม Month และ Year ใน getCardExpMonthYear()