package com.example.billing;


public interface Client {

    public void billUser(String userId, int amount);

}
/*
public class HttpClient {

    private final RestOperations restTemplate;
    Logger logger = LoggerFactory.getLogger(HttpClient.class);

    public HttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "myfallback")
    public void billUser(String userId, int amount) {

        System.out.println("Inside bill user");
        //set your headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //set your entity to send
        HttpEntity entity = new HttpEntity(amount,headers);
        // send it!
        ResponseEntity<String> out = restTemplate.exchange("//billing/reocurringPayment", HttpMethod.POST, entity
                , String.class);


        //restTemplate.postForEntity("http://billing/reocurringPayment", amount, String.class);
    }

    public void myfallback(String userId, int amount) {
        logger.info("fallback" + userId);
        System.out.println("This is my fall back method");

    }
}

*/