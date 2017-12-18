package com.example.subscriptions;

import com.example.billing.ChargeUser;
import com.example.billing.Client;
import com.example.email.SendEmail;

public class CreateSubscription {

    private  Client client;
    private final SendEmail emailSender;
    private final SubscriptionRepository subscriptions;

    public CreateSubscription(
            Client client,
            SendEmail emailSender, SubscriptionRepository subscriptions) {
        this.client = client;
        this.emailSender = emailSender;
        this.subscriptions = subscriptions;
    }

    public void run(String userId, String packageId) {

        System.out.println("Inside run");
        subscriptions.create(new Subscription(userId, packageId));
        client.billUser(userId, 100);
        emailSender.run("me@example.com", "Subscription Created", "Some email body");
    }
}
