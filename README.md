# kafka-joiner

## Deployment

1. Start Kafka Broker
2. Run `kafka-joiner` application
   - topics `address`, `postal-code`, `delivery-address` are created
   - internal topics for state and joins are created
   
## Test

1. Send data to `address` topic with non-null key and value:
```
{
   "name": "", 
   "street": "", 
   "postalCode": ""
}
```
2. Send data to `postalCode` topic, with key=`postalCode` and value:
```
{
   "town": "", 
}
```
3. Inspect `delivery-address` topic