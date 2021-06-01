package cn.seecoder.courselearning.serviceimpl.order;

import cn.seecoder.courselearning.mapperservice.order.CourseOrderMapper;
import cn.seecoder.courselearning.po.order.CourseOrder;
import cn.seecoder.courselearning.service.order.QueryOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class QueryOrderServiceImpl implements QueryOrderService {

    @Resource
    CourseOrderMapper courseOrderMapper;

    @Override
    public CourseOrder queryMostRecentOrder(Integer uid, Integer courseId) {
        return courseOrderMapper.queryMostRecentOrder(uid,courseId);
    }

    @Override
    public CourseOrder getByPrimaryKey(Integer orderId) {
        return courseOrderMapper.selectByPrimaryKey(orderId);
    }
}
