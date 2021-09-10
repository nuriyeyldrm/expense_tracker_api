package com.expensetracker.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @Id
    @SequenceGenerator(name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "confirmation_token_sequence")
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime expiredDate;

    private LocalDateTime confirmedDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private Users users;

    public ConfirmationToken(String token, LocalDateTime createdDate,
                             LocalDateTime expiredDate, Users users) {
        this.token = token;
        this.createdDate = createdDate;
        this.expiredDate = expiredDate;
        this.users = users;
    }
}
