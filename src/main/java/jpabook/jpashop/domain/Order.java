package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    /*
    * 테이터 중심 설계의 문제점
    * 1) 아래와 같은 방식은 객체 설계를 테이블 설계에 맞춘 방식
    * 2) 테이블의 외래키를 객체에 그대로 가져옴
    * 3) 객체 그래프 탐색이 불가능
    * 4) 참조가 없으므로 UML도 잘못됨
    * memberId -> Member 자체를 가져와야 함
    * */
    @Column(name = "MEMBER_ID")
    private Long memberId;

    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
