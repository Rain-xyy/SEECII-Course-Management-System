package cn.seecoder.courselearning.serviceimpl.coupon.couponstrategy;

import cn.seecoder.courselearning.po.coupon.Coupon;
import cn.seecoder.courselearning.util.JSONHelper;
import cn.seecoder.courselearning.vo.order.CourseOrderVO;
import org.springframework.stereotype.Component;

/**
 * 这里的折扣策略不需要满一定数额才能用，可以根据业务需求调整
 */
@Component
public class DiscountCouponStrategy extends AbstractCouponStrategy {
    @Override
    public boolean canUse(CourseOrderVO orderVO, Coupon coupon) {
        Object discountObj = JSONHelper.getByProperty(coupon.getMetadata(), "discount");
        if (discountObj == null) {
            // 无效优惠券
            return false;
        }
        double discount=Double.parseDouble(String.valueOf(discountObj));
        // 判断满减策略
        return super.canUse(orderVO, coupon) && discount > 0 && discount < 1;
    }
    @Override
    public int useCoupon(CourseOrderVO orderVO, Coupon coupon) {
        double discount = Double.parseDouble(String.valueOf(JSONHelper.getByProperty(coupon.getMetadata(), "discount")));
        int initialCost = orderVO.getCost() == null ? orderVO.getOrigin() : orderVO.getCost();
       return (int)(initialCost * discount);
    }
}
