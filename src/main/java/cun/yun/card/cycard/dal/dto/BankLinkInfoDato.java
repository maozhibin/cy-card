package cun.yun.card.cycard.dal.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class BankLinkInfoDato {
    private Long cooperativePartnerId;

    private Integer type;

    private Long linkId;

    private BigDecimal price;

    private String name;

    private String iamge;

    private String url;

    private Integer count;

    private Integer sort;

    private String introduce;
}
