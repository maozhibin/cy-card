package cun.yun.card.cycard.dal.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class LoanLinkInfoDato {
    private Long cooperativePartnerId;

    private Integer type;

    private Long linkId;

    private BigDecimal price;

    private String name;

    private String image;

    private String url;

    private BigDecimal limitMin;

    private BigDecimal limitMax;

    private Double moneyRate;

    private Integer sort;

    private Integer count;
}
