package com.complete.boot.camp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "guardianName")),
        @AttributeOverride(name = "emailId",column= @Column(name = "guardianEmailId")),
        @AttributeOverride(name = "mobile",column = @Column(name = "guardianMobile"))
})
public class Guardian {

    private String name;
    private String emailId;
    private String mobile;

}
