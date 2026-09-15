# WRSCaller decision checklist

Before choosing WRSCaller inside server-side customization:

1. Treat the invocation as an HTTP boundary, not as an in-process Windchill API call.
2. Do not expect an outer `wt.pom.Transaction` to roll back WRS data modifications.
3. Preserve the current principal/access-control semantics.
4. Do not introduce WRSCaller into DataUtility or event-listener hot paths.
5. Do not call WRSCaller from code that is itself implementing/extending WRS.
6. Prefer direct Windchill supported Java APIs when the customization is already running in the MethodServer and an appropriate supported API exists.
7. Handle HTTP status/response explicitly at the calling boundary.
