package com.mcmxc.entities;

import com.mcmxc.entities.enums.TypeRoute;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "routepoint", schema = "logiweb")
public class RoutePoint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id", unique = true, nullable = false)
    private int id;

    @Basic
    @Column(name = "route_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeRoute typeRoute;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "routePoint", cascade = CascadeType.ALL)
    private Set<Cargo> cargoes;

    @ManyToOne
    @JoinColumn(name = "route_city", referencedColumnName = "city_id")
    private City currentCity;

    @ManyToOne
    @JoinColumn(name = "route_order", referencedColumnName = "order_id")
    private Order currentOrder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeRoute getTypeRoute() {
        return typeRoute;
    }

    public void setTypeRoute(TypeRoute typeRoute) {
        this.typeRoute = typeRoute;
    }

    public Set<Cargo> getCargoes() {
        return cargoes;
    }

    public void setCargoes(Set<Cargo> cargoes) {
        this.cargoes = cargoes;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}
