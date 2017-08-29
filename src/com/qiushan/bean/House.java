package com.qiushan.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="house_inf")
public class House {
	@Id
	@Column(name="house_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private Float price;
	@Column(nullable=false)
	private String location;
	@Column(nullable=false)
	private String type;
	@Column(nullable=false)
	private Boolean ishouse;
	@Column(nullable=false)
	private Boolean wrashroom;
	@Column(nullable=false)
	private Boolean bedroom;
	@Column(nullable=false)
	private Integer bedcount;
	@Column(nullable=false)
	private Boolean ispet;
	@Column(nullable=false)
	private String housetype;
	@Column(nullable=false)
	private Boolean cookroom;
	@Column(nullable=false)
	private Boolean breakfast;
	@Column(nullable=false)
	private Boolean wifi;
	@Column(nullable=false)
	private Boolean workspace;
	@Column(nullable=false)
	private String other;
	private String tp_1;
	private String tp_2;
	private String tp_3;
	private String tp_4;
	private String tp_5;
	private String tp_6;
	@Column(columnDefinition="INT default 0")
	private Integer hot;
	@OneToMany(targetEntity=House_goods.class,cascade=CascadeType.ALL)
	@JoinTable(name="house_goods",
			joinColumns=@JoinColumn(name="house_id",
			referencedColumnName="house_id"),
			inverseJoinColumns=@JoinColumn(name="house_goods_id",
			referencedColumnName="house_goods_id",unique=true)
			)
	private Set<House_goods> house_goods=new HashSet<>();
	@Column(nullable=false)
	private Integer houseuser_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getIshouse() {
		return ishouse;
	}
	public void setIshouse(Boolean ishouse) {
		this.ishouse = ishouse;
	}
	public Boolean getWrashroom() {
		return wrashroom;
	}
	public void setWrashroom(Boolean wrashroom) {
		this.wrashroom = wrashroom;
	}
	public Boolean getBedroom() {
		return bedroom;
	}
	public void setBedroom(Boolean bedroom) {
		this.bedroom = bedroom;
	}
	public Integer getBedcount() {
		return bedcount;
	}
	public void setBedcount(Integer bedcount) {
		this.bedcount = bedcount;
	}
	public Boolean getIspet() {
		return ispet;
	}
	public void setIspet(Boolean ispet) {
		this.ispet = ispet;
	}
	public String getHousetype() {
		return housetype;
	}
	public void setHousetype(String housetype) {
		this.housetype = housetype;
	}
	public Boolean getCookroom() {
		return cookroom;
	}
	public void setCookroom(Boolean cookroom) {
		this.cookroom = cookroom;
	}
	public Boolean getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(Boolean breakfast) {
		this.breakfast = breakfast;
	}
	public Boolean getWifi() {
		return wifi;
	}
	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}
	public Boolean getWorkspace() {
		return workspace;
	}
	public void setWorkspace(Boolean workspace) {
		this.workspace = workspace;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getTp_1() {
		return tp_1;
	}
	public void setTp_1(String tp_1) {
		this.tp_1 = tp_1;
	}
	public String getTp_2() {
		return tp_2;
	}
	public void setTp_2(String tp_2) {
		this.tp_2 = tp_2;
	}
	public String getTp_3() {
		return tp_3;
	}
	public void setTp_3(String tp_3) {
		this.tp_3 = tp_3;
	}
	public String getTp_4() {
		return tp_4;
	}
	public void setTp_4(String tp_4) {
		this.tp_4 = tp_4;
	}
	public String getTp_5() {
		return tp_5;
	}
	public void setTp_5(String tp_5) {
		this.tp_5 = tp_5;
	}
	public String getTp_6() {
		return tp_6;
	}
	public void setTp_6(String tp_6) {
		this.tp_6 = tp_6;
	}
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public Set<House_goods> getHouse_goods() {
		return house_goods;
	}
	public void setHouse_goods(Set<House_goods> house_goods) {
		this.house_goods = house_goods;
	}
	public Integer getHouseuser_id() {
		return houseuser_id;
	}
	public void setHouseuser_id(Integer houseuser_id) {
		this.houseuser_id = houseuser_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bedcount == null) ? 0 : bedcount.hashCode());
		result = prime * result + ((bedroom == null) ? 0 : bedroom.hashCode());
		result = prime * result + ((breakfast == null) ? 0 : breakfast.hashCode());
		result = prime * result + ((cookroom == null) ? 0 : cookroom.hashCode());
		result = prime * result + ((hot == null) ? 0 : hot.hashCode());
		result = prime * result + ((house_goods == null) ? 0 : house_goods.hashCode());
		result = prime * result + ((housetype == null) ? 0 : housetype.hashCode());
		result = prime * result + ((houseuser_id == null) ? 0 : houseuser_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ishouse == null) ? 0 : ishouse.hashCode());
		result = prime * result + ((ispet == null) ? 0 : ispet.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((other == null) ? 0 : other.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((tp_1 == null) ? 0 : tp_1.hashCode());
		result = prime * result + ((tp_2 == null) ? 0 : tp_2.hashCode());
		result = prime * result + ((tp_3 == null) ? 0 : tp_3.hashCode());
		result = prime * result + ((tp_4 == null) ? 0 : tp_4.hashCode());
		result = prime * result + ((tp_5 == null) ? 0 : tp_5.hashCode());
		result = prime * result + ((tp_6 == null) ? 0 : tp_6.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((wifi == null) ? 0 : wifi.hashCode());
		result = prime * result + ((workspace == null) ? 0 : workspace.hashCode());
		result = prime * result + ((wrashroom == null) ? 0 : wrashroom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		if (bedcount == null) {
			if (other.bedcount != null)
				return false;
		} else if (!bedcount.equals(other.bedcount))
			return false;
		if (bedroom == null) {
			if (other.bedroom != null)
				return false;
		} else if (!bedroom.equals(other.bedroom))
			return false;
		if (breakfast == null) {
			if (other.breakfast != null)
				return false;
		} else if (!breakfast.equals(other.breakfast))
			return false;
		if (cookroom == null) {
			if (other.cookroom != null)
				return false;
		} else if (!cookroom.equals(other.cookroom))
			return false;
		if (hot == null) {
			if (other.hot != null)
				return false;
		} else if (!hot.equals(other.hot))
			return false;
		if (house_goods == null) {
			if (other.house_goods != null)
				return false;
		} else if (!house_goods.equals(other.house_goods))
			return false;
		if (housetype == null) {
			if (other.housetype != null)
				return false;
		} else if (!housetype.equals(other.housetype))
			return false;
		if (houseuser_id == null) {
			if (other.houseuser_id != null)
				return false;
		} else if (!houseuser_id.equals(other.houseuser_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ishouse == null) {
			if (other.ishouse != null)
				return false;
		} else if (!ishouse.equals(other.ishouse))
			return false;
		if (ispet == null) {
			if (other.ispet != null)
				return false;
		} else if (!ispet.equals(other.ispet))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (this.other == null) {
			if (other.other != null)
				return false;
		} else if (!this.other.equals(other.other))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (tp_1 == null) {
			if (other.tp_1 != null)
				return false;
		} else if (!tp_1.equals(other.tp_1))
			return false;
		if (tp_2 == null) {
			if (other.tp_2 != null)
				return false;
		} else if (!tp_2.equals(other.tp_2))
			return false;
		if (tp_3 == null) {
			if (other.tp_3 != null)
				return false;
		} else if (!tp_3.equals(other.tp_3))
			return false;
		if (tp_4 == null) {
			if (other.tp_4 != null)
				return false;
		} else if (!tp_4.equals(other.tp_4))
			return false;
		if (tp_5 == null) {
			if (other.tp_5 != null)
				return false;
		} else if (!tp_5.equals(other.tp_5))
			return false;
		if (tp_6 == null) {
			if (other.tp_6 != null)
				return false;
		} else if (!tp_6.equals(other.tp_6))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (wifi == null) {
			if (other.wifi != null)
				return false;
		} else if (!wifi.equals(other.wifi))
			return false;
		if (workspace == null) {
			if (other.workspace != null)
				return false;
		} else if (!workspace.equals(other.workspace))
			return false;
		if (wrashroom == null) {
			if (other.wrashroom != null)
				return false;
		} else if (!wrashroom.equals(other.wrashroom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "House [id=" + id + ", name=" + name + ", price=" + price + ", location=" + location + ", type=" + type
				+ ", ishouse=" + ishouse + ", wrashroom=" + wrashroom + ", bedroom=" + bedroom + ", bedcount="
				+ bedcount + ", ispet=" + ispet + ", housetype=" + housetype + ", cookroom=" + cookroom + ", breakfast="
				+ breakfast + ", wifi=" + wifi + ", workspace=" + workspace + ", other=" + other + ", tp_1=" + tp_1
				+ ", tp_2=" + tp_2 + ", tp_3=" + tp_3 + ", tp_4=" + tp_4 + ", tp_5=" + tp_5 + ", tp_6=" + tp_6
				+ ", hot=" + hot + ", house_goods=" + house_goods + ", houseuser_id=" + houseuser_id + "]";
	}

}
