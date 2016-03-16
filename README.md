#Editorial Tools Production Monitoring

These are tests that will against the production tools to confirm the stability of the publishing flow

# Running

Requires /src/test/resources/application.local.conf containing:

    user {
      firstName = <user first name>
      secondName = <user second name>
      email = <user email>
    }
    
    panda {
      domain = <domain>
      system = <system>
    }
    
## Locally:
From the root: `./run_tests.sh`