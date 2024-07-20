package com.bpsi.cjnnetwork.utils;

public class qrcode {

        public String qrcode_filename;
        public String assessment_name;
        public String assessment_test_link;

        public qrcode(String qrcode_filename,String assessment_name) {
            this.assessment_name = assessment_name;
            this.qrcode_filename = qrcode_filename;
        }
        public qrcode(String qrcode_filename,String assessment_name,String assessment_test_link) {
            this.assessment_name = assessment_name;
            this.assessment_test_link=assessment_test_link;
            this.qrcode_filename = qrcode_filename;
        }
}
