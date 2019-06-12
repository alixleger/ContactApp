# **Contact App**

## Documentation API XML

**/api/contact [POST]** : création d'un contact (header requis: "Content-Type: application/xml"")

**/api/contact/{id} [POST]** : modification d'un contact existant (header requis: "Content-Type: application/xml"")

**/api/contact/{id} [GET]** : récupération d'un contact existant

**/api/contact/{id}/delete [GET]** : suppression d'un contact existant

**/api/contacts [GET]** : récupération de tous les contacts

### Contact au format XML

```xml
<contact id="{id}">
    <firstName>{firstName}</firstName>
    <lastName>{lastName}</lastName>
    <phoneNumber>{phoneNumber}</phoneNumber>
    <address>{address}</address>
    <email>{email}</email>
</contact>
```
