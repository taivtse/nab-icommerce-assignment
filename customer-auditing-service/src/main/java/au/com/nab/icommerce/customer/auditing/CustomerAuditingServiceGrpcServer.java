package au.com.nab.icommerce.customer.auditing;

import au.com.nab.icommerce.customer.auditing.api.CustomerAuditingServiceGrpc;
import au.com.nab.icommerce.customer.auditing.protobuf.PCustomerActivity;
import au.com.nab.icommerce.customer.auditing.protobuf.PCustomerActivityListRequest;
import au.com.nab.icommerce.customer.auditing.protobuf.PCustomerActivityListResponse;
import au.com.nab.icommerce.customer.auditing.service.CustomerActivityService;
import com.google.protobuf.Int32Value;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class CustomerAuditingServiceGrpcServer extends CustomerAuditingServiceGrpc.CustomerAuditingServiceImplBase {

    @Autowired
    private CustomerActivityService customerActivityService;

    @Override
    public void addCustomerActivity(PCustomerActivity request, StreamObserver<Int32Value> responseObserver) {
        Int32Value result = customerActivityService.addCustomerActivity(request);
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void addCustomerActivities(PCustomerActivityListRequest request, StreamObserver<Int32Value> responseObserver) {
        Int32Value result = customerActivityService.addCustomerActivities(request);
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void getCustomerActivitiesByCustomerId(Int32Value request, StreamObserver<PCustomerActivityListResponse> responseObserver) {
        PCustomerActivityListResponse result = customerActivityService.getCustomerActivitiesByCustomerId(request);
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
