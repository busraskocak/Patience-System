package patiencenotificationsystem;


import jakarta.persistence.Embeddable;
import lombok.Data;


@Embeddable
@Data
public class NotificationPreference {
    private String type; //None,sms,mail
}
