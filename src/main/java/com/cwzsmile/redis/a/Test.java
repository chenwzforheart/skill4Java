package com.cwzsmile.redis.a;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/24 0024.
 */
public class Test {

    private List<DC5Adapter> adapters = new ArrayList<>();

    public Test() {
        this.adapters.add(new ChinaPowerAdapter());
        this.adapters.add(new JapanPowerAdapter());
    }

    public DC5Adapter getPowerAdapter(AC ac) {
        DC5Adapter adapter = null;
        for (DC5Adapter ad : this.adapters) {
            if (ad.support(ac)) {
                adapter = ad;
                break;
            }
        }
        if (adapter == null) {
            throw new IllegalArgumentException("没有找到合适的表变压器");
        }
        return adapter;
    }

    public static void main(String[] args) {
        /*Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();*/
        Test test = new Test();
        AC chinaAC = new AC220();
        DC5Adapter adapter = test.getPowerAdapter(chinaAC);
        adapter.outputDC5V(chinaAC);

        AC japanAC = new AC110();
        adapter = test.getPowerAdapter(japanAC);
        adapter.outputDC5V(japanAC);
    }
}
