package com.farehawker;

interface PaymentResultListner {
    public void onPaymentSuccess(String razorpayPaymentID);
    public void onPaymentError(int code, String response);

}
