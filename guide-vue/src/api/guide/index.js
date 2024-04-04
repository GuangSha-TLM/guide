import http from "@/utils/requests";
 

export function guideList(listMessage) {
  return http({
    url: "/api/guide/queryByPage",
    method: "post",
    data: listMessage,
  });
}
