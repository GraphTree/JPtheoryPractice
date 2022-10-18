package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.locks.Lock;

@Entity
public class Member{
    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;
    @Column(name = "name")
    private String username;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id",insertable = false, updatable = false)
    private Team team;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locker_id")
    private Locker locker;

    //기간
    @Embedded
    private Period period;
    //주소
    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "favorite_food", joinColumns =
    @JoinColumn(name="member_id")
    )
    @Column(name = "food_name")
    private Set<String> favoriteFooods = new HashSet<>();
    @ElementCollection
    @CollectionTable(name = "address", joinColumns =
    @JoinColumn(name="member_id")
    )
    private List<Address> addressHistory = new ArrayList<Address>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<String> getFavoriteFooods() {
        return favoriteFooods;
    }

    public void setFavoriteFooods(Set<String> favoriteFooods) {
        this.favoriteFooods = favoriteFooods;
    }

    public List<Address> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<Address> addressHistory) {
        this.addressHistory = addressHistory;
    }
}
